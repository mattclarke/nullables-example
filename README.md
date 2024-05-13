# Nullables Example

An attempt to implement James Shore's [Nullables](https://www.jamesshore.com/v2/projects/nullables).

It is based on the discussion in a thread on [Mastodon](https://ieji.de/@davenicolette@mastodon.social/112362275016359712).

## What does it do?
It is a simple program that reads pairs of numbers from a file, finds the biggest difference and prints it to the console.

## Architecture
The program is divided up into three parts:
- the app
- the logic
- the infrastructure

The infrastructure is where the nullables come in, as they allow testing without I/O (e.g. file system, console, etc.).

## Nullables
DataFile is a class responsible for reading a datafile in. It has two static factory methods, `create` and `createNull`.
For the application we use `create` which creates an instance that talks to the real filesystem but for testing we use
`createNull` which creates an instance that doesn't touch the filesystem.
This isn't so different from the usual use of stubs except the stubs live in the production code and not in the tests, and
we write tests for the stubs to check they behave as we expect.

The key difference is that we can construct sociable tests. In this simple example, we can create tests for `App` that use the
nullable `Console` and `DataFile` to check the behaviour of `App`. In a non-nullable style we would typically stub or mock
`Console` and `DataFile` directly which would give isolated tests rather than sociable tests.