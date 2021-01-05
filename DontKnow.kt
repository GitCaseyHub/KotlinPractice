package com.practice

import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class DontKnow: JFrame(), ActionListener {
    private var button : JButton = JButton("Randomize Entered Text")
    private var field : JTextField = JTextField("")

    init{
        println("none")
        this.layout = BorderLayout()
        this.setBounds(100, 100, 500, 100)
        this.isVisible = true
        this.title="Randomize Entered Text"
        this.defaultCloseOperation = EXIT_ON_CLOSE

        this.add(field, BorderLayout.CENTER)
        this.add(button, BorderLayout.SOUTH)
        button.addActionListener(this)
    }
    override fun actionPerformed(e: ActionEvent) {
        if(e.source==button) {
            val returnText: String = (if (field.text.isNotBlank()) randomizeText(field.text) else "You can't randomize nothing")
            field.text=returnText
        }
    }

    private fun randomizeText(text: String): String{
        var newString:String? = ""
        val nums: MutableList<Int> = mutableListOf()
        var randomIndex:Int? = null
        for (x:Int in text.indices){
            while(nums.contains(randomIndex) || randomIndex==null) {
                randomIndex = (text.indices).random()
            }
            nums.add(randomIndex)
            newString+=text.toCharArray()[randomIndex]
        }
        return newString.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            DontKnow()
        }
    }
