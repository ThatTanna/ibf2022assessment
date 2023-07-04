import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

const url = "/api/books";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  // searchValue: string = "";
  currentPage: number = 2;

  getBooksBy(searchValue: string) {
    const query = `SELECT * FROM goodreads WHERE title LIKE '${searchValue}%' LIMIT '${(this.currentPage - 1) * 10}' `;
    console.log(query);
    console.log(searchValue);
    return this.http.get<any[]>(url, {params: {query}});
  }
}
