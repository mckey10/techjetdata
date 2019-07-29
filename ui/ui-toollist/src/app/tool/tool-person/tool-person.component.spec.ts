import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolPersonComponent } from './tool-person.component';

describe('ToolPersonComponent', () => {
  let component: ToolPersonComponent;
  let fixture: ComponentFixture<ToolPersonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ToolPersonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToolPersonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
