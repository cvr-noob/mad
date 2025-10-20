package com.example.unscrambleapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameVM: ViewModel() {
    private var words = listOf("apple", "banana", "cherry").shuffled()
    private var currentIdx = 0
    private var totalScore = 0

    val scrambledWord = MutableLiveData(scramble(words[currentIdx]))
    val score = MutableLiveData(totalScore)

    private fun scramble(word: String) = word.toList().shuffled().joinToString("")

    fun checkGuess(guess: String) {
        if (guess == words[currentIdx])
            totalScore += 10

        currentIdx++
        if (currentIdx < words.size)
            scrambledWord.value = scramble(words[currentIdx])
        else
            scrambledWord.value = "Game Over!"

        score.value = totalScore
    }
}