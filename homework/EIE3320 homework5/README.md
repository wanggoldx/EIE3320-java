# Homework 5 - Media Database with Comments

## What it does

An enhanced database system supporting CD, Video, and VideoGame items. Each item has title, owner status, and comments. Includes search by exact title, title pattern, and general pattern matching.

## How to run

Compile all files and run:
```bash
javac Item.java CD.java Video.java VideoGame.java Database.java TestDatabase.java
java TestDatabase
```

## Dependencies

- Java (any version with ArrayList)
- Item.java - Base class with title, owner, comment
- CD.java - extends Item, adds artist, tracks, playing time
- Video.java - extends Item, adds director, duration
- VideoGame.java - extends Item, adds platform, rating, genre
- Database.java - Storage with addItem(), list(), search methods