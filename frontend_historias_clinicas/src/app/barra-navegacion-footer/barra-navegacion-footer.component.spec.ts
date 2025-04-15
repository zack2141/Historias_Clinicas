import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarraNavegacionFooterComponent } from './barra-navegacion-footer.component';

describe('BarraNavegacionFooterComponent', () => {
  let component: BarraNavegacionFooterComponent;
  let fixture: ComponentFixture<BarraNavegacionFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BarraNavegacionFooterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BarraNavegacionFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
