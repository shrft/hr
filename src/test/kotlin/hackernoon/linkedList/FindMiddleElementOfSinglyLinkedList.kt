package hackernoon.linkedList

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html?source=post_page---------------------------
class FindMiddleElementOfSinglyLinkedList {
    // fromHere
    // 0. write linkedList => done
    // 1. write iterative solution
    // 2. write recursive solution
    @Test
    fun `create linked element`(){
        val el = LinkedElement("element1")
        val el2 = LinkedElement("element2")
        el.next = el2
        println(el.toString())
        println(el.myval)
    }
    fun findMiddleElementOfSinglyLinkedList(firstElement: LinkedElement?): LinkedElement?{
        var elm1 : LinkedElement? = firstElement;
        var elm2 : LinkedElement? = firstElement;
        var counter=1;
        if( !elm1!!.hasNext()) return elm1;

        while( elm1!!.hasNext()) {
            counter++
            elm1 = elm1.next;
            if (counter % 2 === 0) {
                if (elm2!!.hasNext()) {
                    elm2 = elm2!!.next
                }
            }
        }
        return elm2
    }
    fun findNextElement(currentElement:LinkedElement?, middleElement:LinkedElement?, num: Int): LinkedElement?{
        var newMiddleElement: LinkedElement? = middleElement

        if(num % 2 === 0 ){
           newMiddleElement = middleElement!!.next
        }

        val newNum = num+1

        if(currentElement!!.hasNext()){
            return findNextElement(currentElement.next, newMiddleElement, newNum)
        }
        return newMiddleElement
    }
    fun findMiddleElementOfSinglyLinkedListRecursively(firstElement: LinkedElement?): LinkedElement?{
        // 次の要素があるかどうかチェック
        // 次の要素がなければreturn
        // 次の要素があれば、同じ関数をよびだす
        if(!firstElement!!.hasNext()){
            return firstElement
        }
        return findNextElement(firstElement!!.next, firstElement, 1)
//        fromHere: createLinkeListがなんか変
    }
    @Test
    fun `find middle element of singly linked list iterative solution`(){
        val firstElement = createLinkeList(9)
        val resultElement = findMiddleElementOfSinglyLinkedList(firstElement)
        assertEquals("4", resultElement!!.myval)
    }
    @Test
    fun `find middle element of singly linked list recursive solution`(){
        val firstElement = createLinkeList(9)
        val resultElement = findMiddleElementOfSinglyLinkedListRecursively(firstElement)
        assertEquals("4", resultElement!!.myval)
    }
    fun createLinkeList(size:Int): LinkedElement?{
        val lastIndex = size - 1
        var previous: LinkedElement? = null
        var firstElement: LinkedElement? = null
        for(i in 0..lastIndex){
            val el = LinkedElement(i.toString());
            if(previous != null){
                previous.next = el
            }
            previous = el;
            if(i===0){
                firstElement = el
            }
        }
        return firstElement
    }
}
class LinkedElement(val myval: String){
    fun hasNext(): Boolean {
        return next !== null
    }

    var next: LinkedElement? = null
        get() = field
        set(value){
            field = value
        }
}

