import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditPurchaseComponent } from './credit-purchase.component';

describe('CreditPurchaseComponent', () => {
  let component: CreditPurchaseComponent;
  let fixture: ComponentFixture<CreditPurchaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditPurchaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditPurchaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
