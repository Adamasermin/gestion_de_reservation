import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarRechercheComponent } from './bar-recherche.component';

describe('BarRechercheComponent', () => {
  let component: BarRechercheComponent;
  let fixture: ComponentFixture<BarRechercheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BarRechercheComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BarRechercheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
