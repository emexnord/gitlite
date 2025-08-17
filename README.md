# GitLite

GitLite is a lightweight Java implementation that mimics some of the basic features of Git. It is designed as a learning project to understand how version control systems work.

## Project Structure

* **gitlite/** – Core implementation of GitLite (repository logic, commits, file tracking, etc.)
* **gitlite\_cli/** – Command-line interface to interact with GitLite

## Features

* Initialize a new repository
* Add files and create commits
* View commit history
* Checkout previous versions

## Getting Started

1. Clone this repository:

   ```bash
   git clone https://github.com/emexnord/gitlite.git
   cd gitlite
   ```

2. Compile the project:

   ```bash
   javac gitlite/*.java gitlite_cli/*.java
   ```

3. Run the CLI:

   ```bash
   java gitlite_cli.Main init
   ```

## Example Usage

```bash
# Initialize a new repository
java gitlite_cli.Main init  

# Add and commit a file
java gitlite_cli.Main add file.txt  
java gitlite_cli.Main commit "First commit"  

# View history
java gitlite_cli.Main log  

# Checkout a commit
java gitlite_cli.Main checkout <commit_id>  
```

## Notes

This project is for **educational purposes only** and is not intended to replace Git.
