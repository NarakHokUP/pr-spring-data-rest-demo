-- Author
insert into author(id, name) values(1, 'Antonio Sanso');
insert into author(id, name) values(2, 'Justin Richer');
insert into author(id, name) values(3, 'Ryan Boyd');
insert into author(id, name) values(4, 'Tim Messerschmidt');
insert into author(id, name) values(5, 'Matthias Biehl');

-- Book
insert into book(id, title, author_id) values(1, 'The One Thing', 1);
insert into book(id, title, author_id) values(2, 'The 100$ Startup', 3);
insert into book(id, title, author_id) values(3, 'Mastering OAuth2', 5);

-- Library
insert into library(id, name, street) values(1, 'National Library', 'Monivong Blvd.');
insert into library(id, name, street) values(2, 'Hunsen Library', 'Norodom Blvd.');

-- Book_Library
insert into book_library(book_id, library_id) values(1, 1);
insert into book_library(book_id, library_id) values(2, 1);
insert into book_library(book_id, library_id) values(3, 2);
insert into book_library(book_id, library_id) values(1, 2);