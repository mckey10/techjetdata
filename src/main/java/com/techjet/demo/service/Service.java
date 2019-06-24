package com.techjet.demo.service;


import com.techjet.demo.entities.*;

import java.util.Set;


public interface Service {
	//
	// Table operation_material
	//
	public boolean addMaterial(String nameMaterial);
	public boolean addOperation(String nameOperation);
	public boolean setMaterial(String nameOperation, String nameMaterial);
	public Set<Material> getMaterialsByOperation(String nameOperation);
	//public List<Material> getAllMaterials(String nameMaterial);
	public Set<Operation> getOperationByMaterials(String nameMaterial);
	public boolean deleteOperation(String nameOperation);
	public boolean deleteMaterial(String nameMaterial);
	public Set<Operation> getMaterialsJPQL(String nameMaterial);
	//
	// Table machine_operation
	//
	public Set<Operation> getOperationByMachine(String nameMachine);
	public Set<Machine> getMachineByOperation(String nameOperation);
	//
	//-------------Table position_in_block_block-----------
	//
	public Set<Block> getBlockByPositionInBlock(String namePositionInBlock);
	public Set<PositionInBlock> getPositionInBlockByBlock(String nameBlock);
	//
	//-------------Table fixture_block-----------
	//
	public Set<Block> getBlockByFixture(String nameFixture);
	public Set<Fixture> getFixtureByBlock(String nameBlock);
	//
	//-------------Table fixture_machine-----------
	//
	public Set<Machine> getMachineByFixture(String nameFixture);
	public Set<Fixture> getFixtureByMachine(String nameMachine);
	//
	//-------------Table tool_machine-----------
	//
//	public Set<Machine> getMachineByTool(String nameTool);
//	public Set<Tool> getToolByMachine(String nameMachine);
	//
	//-------------Table roottype_apptype-----------
	//
	public Set<RootType> getRootTypeByAppType(String nameAppType);
	public Set<AppType> getAppTypeByRootType(String nameRootType);
	//
	//-------------Table tool_apptype-----------
	//
	public Set<Tool> getToolByAppType(String nameAppType);
	public Set<AppType> getAppTypeByTool(String nameTool);
	public  Set<AppType> getToolJPQL(String nameTool);
	//-------------Table em-----------
	public Em getEmByTool(String nameTool);
	//---------------Table ebm---------
	public Ebm getEbmByTool(String nameTool);
	//--------------Table mmem----------
	public Mmem getMmemByTool(String nameTool);
	//--------------Table pfm----------
	public Pfm getPfmByTool(String nameTool);
	//--------------Table mmslt------------
	public Mmslt getMmsltByTool(String nameTool);
	//--------------Table slt-----------
	public Slt getSltByTool(String nameTool);
	//--------------Table rfr-----------
	public Rfr getRfrByTool(String nameTool);
	//--------------Table rfa-----------
	public Rfa getRfaByTool(String nameTool);
	//--------------Table rfarn-----------
	public Rfarn getRfarnByTool(String nameTool);
	//--------------Table machine-numTool-----------
	public Set<NumTool> getNumToolByMachine(String nameMachine);
	public Set<Machine> getMachineByNumTool(String nameNumTool);
	//--------------Table tool-numTool-----------
	public Set<NumTool> getNumToolByTool(String nameTool);
	public String getToolByNumTool(String nameNumTool);
	public Set<NumTool> getToolJPQL1(String nameTool);
	//--------------Tables numTool properties-----------
	public Holder getHolder(String nameNumTool);
	public Mmaster getMmaser(String nameNumTool);
	public Collet getCollet(String nameNumTool);
	public Shrink getShrink(String nameNumTool);
	public Strshank getStrshank(String nameNumTool);


}
