import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JavaAnalysisReportComponent } from './analysis-report.component';

describe('AnalysisReportComponent', () => {
  let component: JavaAnalysisReportComponent;
  let fixture: ComponentFixture<JavaAnalysisReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JavaAnalysisReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JavaAnalysisReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
