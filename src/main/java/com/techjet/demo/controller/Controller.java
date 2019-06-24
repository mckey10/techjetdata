package com.techjet.demo.controller;

import com.techjet.demo.entities.*;
import com.techjet.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class Controller {
	@Autowired
	Service service;

	//
	// -------------Table operation_material-----------
	//


	@PostMapping(value = "/addMaterial")
	public boolean addMaterial(@RequestParam(name = "material") String nameMaterial) {
		return service.addMaterial(nameMaterial);
	}

	@PostMapping(value = "/addOperation")
	public boolean addOperation(@RequestParam(name = "operation") String nameOperation) {
		return service.addOperation(nameOperation);
	}

	@PostMapping(value = "/setMaterial")
	public boolean setMaterial(@RequestParam(name = "operation") String nameOperation,
							   @RequestParam(name = "material") String nameMaterial) {
		return service.setMaterial(nameOperation, nameMaterial);
	}

	@GetMapping(value = "/getMaterialByOperation")
	public Set<String> getMaterial(@RequestParam(name = "operation") String nameOperation) {
		return service.getMaterialsByOperation(nameOperation).stream()
				.map(n-> n.getNameMaterial()).collect(Collectors.toCollection(HashSet::new));
	}

	@GetMapping(value = "/getOperationByMaterial")
	public Set<String> getOperationMaterial(@RequestParam(name = "material") String nameMaterial) {
		return service.getOperationByMaterials(nameMaterial).stream()
				.map(n-> n.getNameOperation()).collect(Collectors.toCollection(HashSet::new));
	}


	@DeleteMapping(value = "/removeOperation")
	public boolean removeOperation(@RequestParam(name = "operation") String nameOperation) {
		return service.deleteOperation(nameOperation);
	}

	@DeleteMapping(value = "/removeMaterial")
	public boolean removeMaterial(@RequestParam(name = "material") String nameMaterial) {
		return service.deleteMaterial(nameMaterial);
	}
	//only one parameters
	@GetMapping(value = "/getMaterailsJPQL")
	public Set<String> getMaterialsJPQL(@RequestParam(name="material") String nameMaterial){
		return service.getMaterialsJPQL(nameMaterial).stream()
				.map(n-> n.getNameOperation()).collect(Collectors.toCollection(HashSet::new));
	}




	//
	// -------------Table machine_operation-----------
	//
	@GetMapping(value = "/getOperationByMachine")
	public Set<String> getOperationMachine(@RequestParam(name = "machine") String nameMachine) {
		return service.getOperationByMachine(nameMachine).stream()
				.map(n-> n.getNameOperation()).collect(Collectors.toCollection(HashSet::new));
	}

	@GetMapping(value = "/getMachineByOperation")
	public Set<String> getMachineOperation(@RequestParam(name = "operation") String nameOperation) {
		return service.getMachineByOperation(nameOperation).stream()
				.map(n-> n.getNameMachine()).collect(Collectors.toCollection(HashSet::new));
	}

	//
	// -------------Table position_in_block_block-----------
	//
	@GetMapping(value = "/getBlockByPositionInBlock")
	public Set<String> getBlockPositionInBlock(@RequestParam(name = "positionInBlock") String namePositionInBlock) {
		return service.getBlockByPositionInBlock(namePositionInBlock).stream()
				.map(n-> n.getNameBlock()).collect(Collectors.toCollection(HashSet::new));
	}

	@GetMapping(value = "/getPositionInBlockByBlock")
	public Set<String> getPositionInBlockBlock(@RequestParam(name = "block") String nameBlock) {
		return service.getPositionInBlockByBlock(nameBlock).stream()
				.map(n-> n.getNamePositionInBlock()).collect(Collectors.toCollection(HashSet::new));
	}
	//
	// -------------Table fixture_block-----------
	//
	@GetMapping(value = "/getBlockByFixture")
	public Set<String> getBlockByFixture(@RequestParam(name = "fixture") String nameFixture) {
		return service.getBlockByFixture(nameFixture).stream()
				.map(n-> n.getNameBlock()).collect(Collectors.toCollection(HashSet::new));
	}

	@GetMapping(value = "/getFixtureByBlock")
	public Set<String> getFixtureByBlock(@RequestParam(name = "block") String nameBlock) {
		return service.getFixtureByBlock(nameBlock).stream()
				.map(n-> n.getNameFixture()).collect(Collectors.toCollection(HashSet::new));
	}

	//
	// -------------Table fixture_machine-----------
	//
	@GetMapping(value = "/getMachineByFixture")
	public Set<String> getMachineByFixture(@RequestParam(name = "fixture") String nameFixture) {
		return service.getMachineByFixture(nameFixture).stream()
				.map(n-> n.getNameMachine()).collect(Collectors.toCollection(HashSet::new));
	}

	@GetMapping(value = "/getFixtureByMachine")
	public Set<String> getFixtureByMachine(@RequestParam(name = "machine") String nameMachine) {
		return service.getFixtureByMachine(nameMachine).stream()
				.map(n-> n.getNameFixture()).collect(Collectors.toCollection(HashSet::new));
	}


	//
	// -------------Table tool_machine-----------
	//
//	@GetMapping(value = "/getMachineByTool")
//	public Set<Machine> getMachineByTool(@RequestParam(name = "tool")String nameTool){
//		return service.getMachineByTool(nameTool);
//	}
//
//	@GetMapping(value = "/getToolByMachine")
//	public Set<Tool> getToolByMachine(@RequestParam(name = "machine")String nameMachine){
//		return service.getToolByMachine(nameMachine);
//	}
	//
	// -------------Table roottype_apptype-----------
	//
	@GetMapping(value = "/getRootTypeByAppType")
	public Set<String> getRootTypeByAppType(@RequestParam(name = "appType") String nameAppType){
		return service.getRootTypeByAppType(nameAppType).stream()
				.map(n-> n.getNameRootType()).collect(Collectors.toCollection(HashSet::new));
	}
	@GetMapping(value = "/getAppTypeByRootType")
	public Set<String> getAppTypeByRootType(@RequestParam(name = "rootType")String nameRootType){
		return service.getAppTypeByRootType(nameRootType).stream()
				.map(n-> n.getNameAppType()).collect(Collectors.toCollection(HashSet::new));
	}
	//
	// -------------Table tool_apptype-----------
	//
	@GetMapping(value = "/getToolByAppType")
	public Set<String> getToolByAppType(@RequestParam(name = "appType") String nameAppType){
		return service.getToolByAppType(nameAppType).stream()
				.map(n-> n.getNameTool()).collect(Collectors.toCollection(HashSet::new));
	}
	@GetMapping(value = "/getAppTypeByTool")
	public Set<String> getAppTypeByTool(@RequestParam(name = "tool")String nameTool){
		return service.getAppTypeByTool(nameTool).stream()
				.map(n-> n.getNameAppType()).collect(Collectors.toCollection(HashSet::new));
	}
	@GetMapping(value = "/getToolJPQL")
	public Set<AppType> getToolJPQL(@RequestParam(name="tool") String nameTool) {
		return service.getToolJPQL(nameTool);
	}
	//
	// -------------Table em-----------
	//
	@GetMapping(value = "/getEmByTool")
	public Em getEmByTool(@RequestParam(name = "tool")String nameTool) {
		return service.getEmByTool(nameTool);
	}
	//------------Table ebm------
	@GetMapping(value = "/getEbmByTool")
	public Ebm getEbmByTool(@RequestParam(name = "tool")String nameTool) {return service.getEbmByTool(nameTool); }
	//------------Table mmem------
	@GetMapping(value = "/getMmemByTool")
	public Mmem getMmemByTool(@RequestParam(name = "tool")String nameTool) {return service.getMmemByTool(nameTool); }
	//------------Table pfm------
	@GetMapping(value = "/getPfmByTool")
	public Pfm getPfmByTool(@RequestParam(name = "tool")String nameTool) {return service.getPfmByTool(nameTool); }
	//------------Table mmslt------
	@GetMapping(value = "/getMmsltByTool")
	public Mmslt getMmsltByTool(@RequestParam(name = "tool")String nameTool) {return service.getMmsltByTool(nameTool); }
	//------------Table slt--------
	@GetMapping(value = "/getSltByTool")
	public Slt getSltByTool(@RequestParam(name = "tool")String nameTool) {return service.getSltByTool(nameTool); }
	//------------Table rfr--------
	@GetMapping(value = "/getRfrByTool")
	public Rfr getRfrByTool(@RequestParam(name = "tool")String nameTool) {return service.getRfrByTool(nameTool); }
	//------------Table rfa--------
	@GetMapping(value = "/getRfaByTool")
	public Rfa getRfaByTool(@RequestParam(name = "tool")String nameTool) {return service.getRfaByTool(nameTool); }
	//------------Table rfarn--------
	@GetMapping(value = "/getRfarnByTool")
	public Rfarn getRfarnByTool(@RequestParam(name = "tool")String nameTool) {return service.getRfarnByTool(nameTool); }
	//
	//--------------Table machine-numTool-----------
	//
	@GetMapping(value = "/getNumToolByMachine")
	public Set<String> getNumToolByMachine(@RequestParam(name = "machine") String nameMachine){
		return service.getNumToolByMachine(nameMachine).stream()
				.map(n-> n.getNameNumTool()).collect(Collectors.toCollection(HashSet::new));
	}
	@GetMapping(value = "/getMachineByNumTool")
	public Set<String> getMachineByNumTool(@RequestParam(name = "numTool")String nameNumTool){
		return service.getMachineByNumTool(nameNumTool).stream()
				.map(n-> n.getNameMachine()).collect(Collectors.toCollection(HashSet::new));
	}
	//
	//--------------Table tool-numTool-----------
	//
	@GetMapping(value = "/getNumToolByTool")
	public Set<String> getNumToolByTool(@RequestParam(name = "tool")String nameTool){
		return service.getNumToolByTool(nameTool).stream()
				.map(n-> n.getNameNumTool()).collect(Collectors.toCollection(HashSet::new));
	}
	@GetMapping(value = "/getToolByNumTool")
	public String getToolByNumTool(@RequestParam(name = "numTool")String nameNumTool){
		return service.getToolByNumTool(nameNumTool);//ploho rabotaet
	}
	@GetMapping(value = "/getToolJPQL1")
	public Set<String> getToolJPQL1(@RequestParam(name="tool") String nameTool){
		return service.getToolJPQL1(nameTool).stream().map(n-> n.getNameNumTool()).collect(Collectors.toCollection(HashSet::new));
	}
	//--------------Tables numTool properties-----------
	@GetMapping(value = "/getHolder")
	public Holder getHolder(@RequestParam(name = "numTool")String nameNumTool) {
		return service.getHolder(nameNumTool);
	}
	@GetMapping(value = "/getMmaster")
	public Mmaster getMmaster(@RequestParam(name = "numTool")String nameNumTool) {
		return service.getMmaser(nameNumTool);
	}
	@GetMapping(value = "/getCollet")
	public Collet getCollet(@RequestParam(name = "numTool")String nameNumTool) {
		return service.getCollet(nameNumTool);
	}
	@GetMapping(value = "/getShrink")
	public Shrink getShrink(@RequestParam(name = "numTool")String nameNumTool) {
		return service.getShrink(nameNumTool);
	}
	@GetMapping(value = "/getStrshank")
	public Strshank getStrshank(@RequestParam(name = "numTool")String nameNumTool) {
		return service.getStrshank(nameNumTool);
	}

}
