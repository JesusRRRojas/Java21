import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EscuelaConductorDetailsComponent } from './escuela-conductor-details.component';

describe('EscuelaConductorDetailsComponent', () => {
  let component: EscuelaConductorDetailsComponent;
  let fixture: ComponentFixture<EscuelaConductorDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EscuelaConductorDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EscuelaConductorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
