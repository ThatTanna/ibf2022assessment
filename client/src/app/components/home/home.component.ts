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

  searchValue!: string;
  limit: number = 10;
  offset: number = 0;

  constructor(private bookService: BookService, private router: Router) { }

  listBooks(value: string) {
    console.log(value);
    this.bookService.getBooksBy(value);
    this.router.navigate(['/book-list']);
  }

}
