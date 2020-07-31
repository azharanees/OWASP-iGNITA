import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JavaScannerComponent } from './java-scanner.component';

describe('JavaScannerComponent', () => {
  let component: JavaScannerComponent;
  let fixture: ComponentFixture<JavaScannerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JavaScannerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JavaScannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
