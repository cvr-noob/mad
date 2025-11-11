package com.example.unscrambleapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameVM: ViewModel() {
    private var words = listOf("apple", "banana", "cherry")
    private var _score: Int = 0
    private var idx = 0

    var scrambled = MutableLiveData(scramble(words[idx]))
    val score = MutableLiveData(_score)

    private fun scramble(word: String) = word.toList().shuffled().joinToString("")

    fun guess(word: String) {
        if (word == words[idx]) {
            _score += 10
            score.value = _score

            idx++
            if (idx >= words.size)
                scrambled.value = "Game Over!"
            else
                scrambled.value = scramble(words[idx])
        }
    }
}
