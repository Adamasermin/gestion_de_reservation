import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatReserComponent } from './stat-reser.component';

describe('StatReserComponent', () => {
  let component: StatReserComponent;
  let fixture: ComponentFixture<StatReserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatReserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatReserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
