# Library Management System (Lab 2)

## Overview

This lab implements a Library Management System with custom data structures and a Swing-based GUI. It demonstrates fundamental data structure concepts including linked lists, queues, and a complete book borrowing system with reservation functionality.

## Components

### Data Structures
- **MyList** - Interface defining list operations (extends Collection)
- **MyLinkedList** - Generic linked list implementation
- **MyQueue** - Generic queue implementation using linked list
- **Book** - Book class with title, ISBN, availability status, and reservation queue

### GUI System
- **GUI** - Swing-based graphical interface for managing books
  - Add, Edit, Delete, Search books
  - Borrow/Return books
  - Reserve books (waiting queue)
  - Sort by ISBN or Title
  - Import/Export data to file

## Files

| File | Description |
|------|------------|
| `src/MyList.java` | List interface |
| `src/MyLinkedList.java` | Linked list implementation |
| `src/MyQueue.java` | Queue implementation |
| `src/Book.java` | Book entity class |
| `src/GUI.java` | Main GUI application |
| `src/TestBook.java` | Test Book class |
| `src/TestMyLinkedList.java` | Test linked list |
| `src/TestMyQueue.java` | Test queue |
| `book_record.txt` | Data file for import/export |

## Setup

1. Ensure Java Development Kit (JDK) 8 or higher is installed
2. Navigate to the `src` directory:
   ```bash
   cd lab2/lab2/src
   ```

## Running

### Run the GUI Application
```bash
javac GUI.java
java GUI
```

### Run Test Programs
```bash
javac TestMyLinkedList.java
java TestMyLinkedList

javac TestMyQueue.java
java TestMyQueue

javac TestBook.java
java TestBook
```

## Features

- **Add Book**: Add new books with ISBN and Title (ISBN must be unique)
- **Edit Book**: Modify existing book details
- **Delete Book**: Remove books from the system
- **Search**: Find books by ISBN or Title
- **Borrow**: Mark book as borrowed (unavailable)
- **Return**: Return book; automatically assigns to next person in reservation queue if available
- **Reserve**: Add user to waiting queue for unavailable book
- **Sort**: Display books sorted by ISBN or Title
- **Import/Export**: Save and load book data from `book_record.txt`
- **Load Test Data**: Pre-populate with 3 sample books