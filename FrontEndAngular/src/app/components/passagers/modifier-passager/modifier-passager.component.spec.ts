import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierPassagerComponent } from './modifier-passager.component';

describe('ModifierPassagerComponent', () => {
  let component: ModifierPassagerComponent;
  let fixture: ComponentFixture<ModifierPassagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModifierPassagerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifierPassagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
