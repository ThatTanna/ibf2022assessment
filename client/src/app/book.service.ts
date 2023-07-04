import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Book } from './models/Book.model';

const url = "/api/books";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getBooksBy(searchValue: string, limit: number, offset: number): Observable<Book[]> {
    let params = new HttpParams()
      .set('searchValue', searchValue)
      .set('limit', limit)
      .set('offset', offset)
    console.log(url);
    console.log("params: " + params);
    console.log("searchValue: " + searchValue);
    console.log("limit:" + limit);
    return this.http.get<Book[]>(url, { params });
  }

  hello() {
    return this.http.get<any>("/api/books/hello");
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${url}/all`);
  }
}
