import { Component, OnInit } from '@angular/core';
import { KambaService } from '../../services/kamba.service';
import { Transaction } from '../../interfaces/transaction.interface';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    private transactionsObject: any = {};

    constructor(
        private kambaService: KambaService
    ) { }

    ngOnInit(): void {
        this.kambaService.getTransactions().subscribe((transaction: {}) => {
            this.transactionsObject = transaction;
            console.log(transaction);
        });
    }

    public get transactions(): any {
        return this.transactionsObject;
    }
}
