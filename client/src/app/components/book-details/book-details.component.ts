import { Component } from '@angular/core';
import { BookService } from 'src/app/book.service';
import { Book } from 'src/app/models/Book.model';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent {

  bookDetails!: Book;
  bookList: Book[] = [];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.loadAllBooks();
  }

  loadAllBooks(): void {
    this.bookService.getAllBooks()
      .subscribe({
        next: (data) => {
          this.bookList = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      })
  }

}
