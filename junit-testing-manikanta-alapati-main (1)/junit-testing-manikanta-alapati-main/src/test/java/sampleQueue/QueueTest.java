package sampleQueue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;

	@Test
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

	@Test
	@DisplayName("Peek should throw an Exception if called on empty queue")
	void peekThrowsExceptionOnEmpty(){
		assertThrows(NoSuchElementException.class, () -> this.q.peek());
	}

	//Example of Wrong Test!
	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}

    @Test
    @DisplayName("Test empty Constructor")
    void testConstructor1(){
        q = new Queue<String>();
        assertEquals(0, q.length());
        assertTrue(q.isEmpty());
    }

    @Test
    @DisplayName("Test Non-Empty Constructor")
    void testConstructor2(){
        q = new Queue<String>(10);
        assertEquals(0, q.length());
        assertTrue(q.isEmpty());
    }

    @Test
    @DisplayName("enqueue should throw an error when maxLength is crossed")
    void testEnqueue(){
        q = new Queue<String>(3);
        q.enqueue(SOME_ITEM);
        q.enqueue(SOME_ITEM);
        q.enqueue(SOME_ITEM);
        assertThrows(RuntimeException.class, ()->q.enqueue(SOME_ITEM));
    }

    @Test
    @DisplayName("peek should throw an error if queue is empty")
    void testPeekOnEmpty(){
        assertThrows(NoSuchElementException.class, ()->this.q.peek());
    }

    @Test
    @DisplayName("peek should return the first element if queue is not empty")
    void testPeek(){
        this.q.enqueue(SOME_ITEM);
        assertEquals(SOME_ITEM, this.q.peek());
    }

    @Test
    @DisplayName("length should return an int when called on non-empty queue")
    void testLength(){
        this.q.enqueue(SOME_ITEM);
        assertEquals(1,this.q.length());
    }

    @Test
    @DisplayName("length should return 0. when called on empty queue")
    void testLengthOnEmpty(){
        assertEquals(0,this.q.length());
    }

    @Test
    @DisplayName("IsEmpty should return ture if called on Empty queue")
    void testIsEmpty(){
        assertTrue(this.q.isEmpty());
        this.q.enqueue(SOME_ITEM);
        assertFalse(this.q.isEmpty());
    }

    @Test
    @DisplayName("length should return 0. when called on queue after calling RemoveAll")
    void testRemoveAll(){
        this.q.enqueue(SOME_ITEM);
        this.q.enqueue(SOME_ITEM);
        assertEquals(2, this.q.length());
        assertFalse(this.q.isEmpty());
        this.q.removeAll();
        assertEquals(0,this.q.length());
        assertTrue(this.q.isEmpty());
    }

    @Test
    @DisplayName("Dequeue should return first element when called on non-empty queue")
    void testDequeue(){
        this.q.enqueue(SOME_ITEM);
        assertEquals(SOME_ITEM, this.q.dequeue());
    }

    @Test
    @Disabled
    @DisplayName("Dequeue should throw NoSuchElementException when called on Empty queue")
    void testDequeueOnEmpty(){
        assertThrows(NoSuchElementException.class, ()->this.q.dequeue());
    }


    @Test
    @DisplayName("to string")
    void testtostring(){
        this.q.enqueue(SOME_ITEM);
        this.q.toString();
    }
    @Test
    @DisplayName("remove")
    void testoremove(){
        this.q.enqueue(SOME_ITEM);
        assertThrows(UnsupportedOperationException.class, ()->this.q.iterator().remove());
    }
    @Test
    @DisplayName("Main")
    void main(){
        String[] a = new String[1];
        this.q.main(a);
    }

    @Test
    @DisplayName("next")
    void testonext(){
        assertThrows(NoSuchElementException.class,()->this.q.iterator().next());
    }

}

