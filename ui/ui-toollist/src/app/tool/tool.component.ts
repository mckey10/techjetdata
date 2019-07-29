import { Component, OnInit } from '@angular/core';
import Tool from "./Tool";
import Person from "./Person";

@Component({
  selector: 'app-tool',
  templateUrl: './tool.component.html',
  styleUrls: ['./tool.component.css']
})
export class ToolComponent implements OnInit {

  public tools: Tool[]= [];
  public persons: Person[]= [];

  constructor() { }

  ngOnInit() {
    this.tools.push(
      new Tool(147, 'rough', '4ts-15096/201', 'ER32x100 seal 15-16', 140, 180, 800, 'R', 3, 100),
      new Tool(117, 'slot te', '5tc-106338', 'ER32x100 1sc-37009', 140, 75, 500, 'R', 0.25, 300),
      new Tool(128, 'a/e le', '4ts-15096/222', 'ER32x100 1sc-37009', 140, 120, 800, 'R', 0.4, 400),
    )

    this.persons.push(
      new Person('A12345', 3,'PVR590', 'B762-CP', 'Andrey M.', 'Oleg R.', '15/07/19', 'Titanium', '100x100',
        '4205', 'FX-123', 'Okuma MU-400VA', 'Axial Rotor'),
    )
  }

}
