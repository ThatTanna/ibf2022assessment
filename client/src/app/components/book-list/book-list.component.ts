import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService } from 'src/app/book.service';
import { Book } from 'src/app/models/Book.model';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent {
  
  searchValue: string = "";
  limit: number = 10;
  offset: number = 0;
  bookList: Book[] = [];

  constructor(private activatedRoute: ActivatedRoute, private bookService: BookService) { }

  // ngOnInit(){
  //   this.activatedRoute.queryParams.subscribe({
  //     next: (queryParams) => {
  //       this.searchValue = queryParams['searchValue']
  //       console.log("booklist: " + queryParams);
  //       this.bookService.getBooksBy(this.searchValue, this.limit, this.offset)
  //     }
  //   })
  // }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe({
      next: (data) => {
        this.searchValue = data['searchValue']
      }
    })
    this.bookService.getBooksBy(this.searchValue, this.limit, this.offset)
      .subscribe({
        next: (data) => {
          this.bookList = data;
          console.log(this.bookList.forEach);
        },
        error: (e) => console.error(e)
      })
  }

  bookDetails(){
    this.activatedRoute.snapshot
  }


}
