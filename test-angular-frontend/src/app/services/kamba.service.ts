import { Injectable } from '@angular/core';
import {
    HttpClient,
    HttpHeaders
} from '@angular/common/http';
import {
    retry,
    catchError
} from 'rxjs/operators';
import {
    Observable,
    throwError
} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class KambaService {

    private backendURL = 'https://kamba-test-rails.herokuapp.com/api/v1/';

    private httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };

    constructor(
        private http: HttpClient
    ) { }

    public getTransactions(): Observable<any> {
        return this.http.get<any>(this.backendURL + 'kambas', this.httpOptions)
            .pipe(
                retry(3),
                catchError(this.handleError)
            );
    }

    private handleError(error: any): Observable<never> {
        const errorMessage = error.error instanceof ErrorEvent
            ? error.error.message
            : `Error Code: ${error.status}
               Message: ${error.message}`;

        window.alert(errorMessage);
        return throwError(errorMessage);
    }
}
