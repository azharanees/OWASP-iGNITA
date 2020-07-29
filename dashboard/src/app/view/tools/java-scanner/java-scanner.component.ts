import { OnInit, AfterViewInit, Component, ElementRef, Inject } from '@angular/core';
import '@vaadin/vaadin-upload';
import { FormControl, Validators } from '@angular/forms';
import { MatBottomSheet, MatBottomSheetRef } from '@angular/material/bottom-sheet';
import { MAT_BOTTOM_SHEET_DATA } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { RestApiService } from '../../../shared/rest-api.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { JavaAnalysisReportComponent } from './java-analysis-report/analysis-report.component';


@Component({
  selector: 'app-java-scanner',
  templateUrl: './java-scanner.component.html',
  styleUrls: ['./java-scanner.component.css']
})
export class JavaScannerComponent implements OnInit {
  reg = '(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?';
  uploadFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(this.reg)


    ,
  ]);


  constructor(private elementRef: ElementRef, private _bottomSheet: MatBottomSheet, public dialog: MatDialog) { }

  ngOnInit() {
  }
  upload: any;
  projectId: String;
  bugList:any;
  response:any;

  uploadFiles() {
    this.upload.uploadFiles();
    console.log("jar uploaded");



  }
openDialog(response): void {  
    const _this = this;
    const dialogRef = this.dialog.open(JavaAnalysisReportComponent, {
      width: '100%',
      height: "100%",
      maxHeight: "100%",
      maxWidth: "100%",
      data: {
        projectId: response.id,
        data:response,
      },
      
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }

   

  ngAfterViewInit() {
    var _this = this;
    this.upload = this.elementRef.nativeElement.querySelector("vaadin-upload#manualUpload")
    this.upload.addEventListener('upload-response', function (event) {
      var response = JSON.parse(event.detail.xhr.response);
      _this.openDialog(response);
      if (event.detail.xhr.response.status != 200) {
        event.detail.file.error = event.detail.xhr.response.error;


      }
    });

  }

  getProjectId(): String {
    return this.projectId;
  }




}



