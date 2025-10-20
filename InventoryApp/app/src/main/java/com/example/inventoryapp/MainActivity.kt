package com.example.inventoryapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val db = ItemDB.getInstance(this)
            App(db.dao())
        }
    }
}

@Composable
fun App(itemDao: ItemDao) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var qty by remember { mutableStateOf("") }
    val items by itemDao.getAll().observeAsState(listOf())

    fun toast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID (for update/delete)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = qty,
            onValueChange = { qty = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                if (name.isNotBlank() && qty.isNotBlank()) scope.launch {
                    itemDao.insert(
                        Item(name = name, qty = qty.toInt())
                    ); toast("Inserted"); name = ""; qty = ""
                }
            }) { Text("Insert") }
            Button(onClick = {
                if (id.isNotBlank() && name.isNotBlank() && qty.isNotBlank()) scope.launch {
                    itemDao.update(
                        Item(id = id.toInt(), name = name, qty = qty.toInt())
                    ); toast("Updated"); id = ""; name = ""; qty = ""
                }
            }) { Text("Update") }
            Button(onClick = {
                if (id.isNotBlank()) scope.launch {
                    itemDao.delete(
                        Item(
                            id = id.toInt(),
                            name = "",
                            qty = 0
                        )
                    ); toast("Deleted"); id = ""
                }
            }) { Text("Delete") }
        }
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(items) { item ->
                Text("ID: ${item.id} | ${item.name} | ${item.qty}")
                HorizontalDivider()
            }
        }
    }
}
