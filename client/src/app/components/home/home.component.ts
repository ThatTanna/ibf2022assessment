import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  ALPHABETS: string[] = [
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
    'U', 'V', 'W', 'X', 'Y', 'Z'
  ]

  NUMBERS: string[] = [
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
  ]

  constructor(private router: Router, private bookService: BookService) { }

  listBooks(searchValue: string) {
    console.log(searchValue);
    this.router.navigate(['/book-list'],
      {
        queryParams: { searchValue }
      });
  }

  hello() {
    console.log("hello!!");
    this.bookService.hello;
    this.router.navigate(['/book-details'])
  }

}
