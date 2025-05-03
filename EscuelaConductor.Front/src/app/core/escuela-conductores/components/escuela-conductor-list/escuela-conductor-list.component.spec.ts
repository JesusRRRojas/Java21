import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EscuelaConductorListComponent } from './escuela-conductor-list.component';

describe('EscuelaConductorListComponent', () => {
  let component: EscuelaConductorListComponent;
  let fixture: ComponentFixture<EscuelaConductorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EscuelaConductorListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EscuelaConductorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
