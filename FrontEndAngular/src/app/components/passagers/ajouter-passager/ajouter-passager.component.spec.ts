import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterPassagerComponent } from './ajouter-passager.component';

describe('AjouterPassagerComponent', () => {
  let component: AjouterPassagerComponent;
  let fixture: ComponentFixture<AjouterPassagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AjouterPassagerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjouterPassagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
