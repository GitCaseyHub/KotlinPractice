package com.practice

import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class DontKnow: JFrame(), ActionListener {
    var button : JButton = JButton("Randomize Text")
    var field : JTextField = JTextField("")

    init{
        this.layout = BorderLayout()
        this.setBounds(100, 100, 500, 100)
        this.isVisible = true
        this.title="Randomize Entered Text"

        this.add(field, BorderLayout.CENTER)
        this.add(button, BorderLayout.SOUTH)
            button.addActionListener(this)
    }
    override fun actionPerformed(e: ActionEvent?) {
        if(e?.source==button) {
            val returnText: String =
                if (field.text.isNotBlank()) randomizeText(field.text) else "You can't randomize nothing"
            println(returnText)
        }
    }

    private fun randomizeText(text: String): String{
        val charArray: CharArray = text.toCharArray()
        var newString:String? = ""
        val nums: MutableList<Int> = mutableListOf()
        var counter=0
        val range: Int = text.length
        while(counter<text.length){
            var randomIndex=69
            while(nums.contains(randomIndex) || randomIndex==69) {
                randomIndex = (0 until range).random()
            }
            nums.add(randomIndex)
            newString+=charArray[randomIndex]
            counter++
        }
        return newString.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            DontKnow()
        }
    }
}
