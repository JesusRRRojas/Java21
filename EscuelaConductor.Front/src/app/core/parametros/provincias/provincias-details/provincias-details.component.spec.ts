import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProvinciasDetailsComponent } from './provincias-details.component';

describe('ProvinciasDetailsComponent', () => {
  let component: ProvinciasDetailsComponent;
  let fixture: ComponentFixture<ProvinciasDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProvinciasDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProvinciasDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
