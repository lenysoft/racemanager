import { Component, OnInit }    from '@angular/core';
import { Driver }               from '../../entity/driver';
import { DriverService }        from '../../services/driver.service';

@Component({
    selector: 'view-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
    drivers: Driver[] = [];

    constructor(private driverService: DriverService) { }

    ngOnInit() {
      this.getDrivers();
    }

    getDrivers(): void {
      this.driverService.list()
        .subscribe(drivers => this.drivers = drivers.slice(1, 5));
    }
}
