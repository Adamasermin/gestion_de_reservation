import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassagersComponent } from './passagers.component';

describe('PassagersComponent', () => {
  let component: PassagersComponent;
  let fixture: ComponentFixture<PassagersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PassagersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassagersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
