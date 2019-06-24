package com.techjet.demo.service;

import com.techjet.demo.entities.*;
import com.techjet.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    MaterialsJpaRepository materialsRepo;

    @Autowired
    OperationsJpaRepository operationsRepo;

    @Autowired
    MachinesJpaRepository machinesRepo;

    @Autowired
    PositionInBlockJpaRepository positionInBlockRepo;

    @Autowired
    BlockJpaRepository blockRepo;
    
    @Autowired
    FixtureJpaRepository fixtureRepo;

    @Autowired
    ToolJpaRepository toolRepo;

    @Autowired
    RootTypeJpaRepository rootTypeRepo;

    @Autowired
    AppTypeJpaRepository appTypeRepo;

    @Autowired
    NumToolJpaRepository numToolRepo;

    //
    // -------------Table operation_material-----------
    //

    @Override
    public boolean addMaterial(String nameMaterial) {
        if (materialsRepo.existsById(nameMaterial)) return false;
        materialsRepo.save(new Material(nameMaterial));
        return true;
    }

    @Override
    public boolean addOperation(String nameOperation) {
        if (operationsRepo.existsById(nameOperation)) return false;
        operationsRepo.save(new Operation(nameOperation));
        return true;
    }


    @Override
    public boolean setMaterial(String nameOperation, String nameMaterial) {
        addMaterial(nameMaterial);
        addOperation(nameOperation);
        Material material = materialsRepo.findById(nameMaterial).get();
        Operation operation = operationsRepo.findById(nameOperation).get();
        operation.getMaterial().add(material);
        operationsRepo.save(operation);

        return true;
    }

    @Override
    @Transactional(readOnly=true)
    public Set<Material> getMaterialsByOperation(String nameOperation) {
        Operation operation = operationsRepo.findById(nameOperation).orElse(null);
        return operation == null ? new HashSet<Material>() : operation.getMaterial();

    }




    @Override
    @Transactional(readOnly=true)
    public Set<Operation> getOperationByMaterials(String nameMaterial) {
        Material material = materialsRepo.findById(nameMaterial).orElse(null);
        return material == null ? new HashSet<Operation>() : material.getOperation();
    }

    @Override
    public boolean deleteOperation (String nameOperation){
            if (!operationsRepo.existsById(nameOperation)) return false;
            operationsRepo.deleteById(nameOperation);
            return true;

    }

    @Override
    public boolean deleteMaterial (String nameMaterial){
            if (!materialsRepo.existsById(nameMaterial)) return false;
            materialsRepo.deleteById(nameMaterial);
            return true;
    }



    @Override
    @Transactional(readOnly = true)
    public Set<Operation> getMaterialsJPQL (String nameMaterial){
            return operationsRepo.getMaterialsJPQL(nameMaterial);
    }

    //
    // -------------Table machine_operation-----------
    //
  @Override
  @Transactional(readOnly=true)
  public Set<Operation> getOperationByMachine(String nameMachine) {
      Machine machine = machinesRepo.findById(nameMachine).orElse(null);
      return machine == null ? new HashSet<Operation>() : machine.getOperation();
  }

  @Override
  @Transactional(readOnly=true)
  public Set<Machine> getMachineByOperation(String nameOperation) {
      Operation operation = operationsRepo.findById(nameOperation).orElse(null);
      return operation == null ? new HashSet<Machine>() : operation.getMachine();
  }



    //
    // -------------Table position_in_block_block-----------
    //

    @Override
    @Transactional(readOnly=true)
    public Set<Block> getBlockByPositionInBlock(String namePositionInBlock) {
        PositionInBlock positionInBlock = positionInBlockRepo.findById(namePositionInBlock).orElse(null);
        return positionInBlock == null ? new HashSet<Block>() : positionInBlock.getBlock();
    }

    @Override
    @Transactional(readOnly=true)
    public Set<PositionInBlock> getPositionInBlockByBlock(String nameBlock) {
        Block block = blockRepo.findById(nameBlock).orElse(null);
        return block == null ? new HashSet<PositionInBlock>() : block.getPositionInBlock();
    }

	//
    // -------------Table fixture_block-----------
    //
    @Override
	public Set<Block> getBlockByFixture(String nameFixture) {
		Fixture fixture = fixtureRepo.findById(nameFixture).orElse(null);
		return fixture == null ? new HashSet<Block>() : fixture.getBlock();
	}

	@Override
	public Set<Fixture> getFixtureByBlock(String nameBlock) {
		Block block = blockRepo.findById(nameBlock).orElse(null);
		return block == null ? new HashSet<Fixture>() : block.getFixture();
	}

    //
    // -------------Table fixture_machine-----------
    //

    @Override
    public Set<Machine> getMachineByFixture(String nameFixture) {
        Fixture fixture = fixtureRepo.findById(nameFixture).orElse(null);
        return fixture == null ? new HashSet<Machine>() : fixture.getMachine();
    }

    @Override
    public Set<Fixture> getFixtureByMachine(String nameMachine) {
        Machine machine = machinesRepo.findById(nameMachine).orElse(null);
        return machine == null ? new HashSet<Fixture>() : machine.getFixture();
    }
    //
    // -------------Table tool_machine-----------
    //
//    @Override
//    public Set<Machine> getMachineByTool(String nameTool) {
//        Tool tool = toolRepo.findById(nameTool).orElse(null);
//        return tool == null ? new HashSet<Machine>() : tool.getMachine();
//    }
//
//    @Override
//    public Set<Tool> getToolByMachine(String nameMachine) {
//        Machine machine = machinesRepo.findById(nameMachine).orElse(null);
//        return machine == null ? new HashSet<Tool>() : machine.getTool();
//    }

    //
    // -------------Table roottype_apptype-----------
    //

    @Override
    public Set<RootType> getRootTypeByAppType(String nameAppType) {
        AppType appType = appTypeRepo.findById(nameAppType).orElse(null);
        return appType == null ? new HashSet<RootType>() : appType.getRootType();
    }

    @Override
    public Set<AppType> getAppTypeByRootType(String nameRootType) {
        RootType rootType = rootTypeRepo.findById(nameRootType).orElse(null);
        return rootType == null ? new HashSet<AppType>() : rootType.getAppType();
    }
    //
    // -------------Table tool_apptype-----------
    //
    @Override
    public Set<Tool> getToolByAppType(String nameAppType) {
        AppType appType = appTypeRepo.findById(nameAppType).orElse(null);
        return appType == null ? new HashSet<Tool>() : appType.getTool();
    }

    @Override
    public Set<AppType> getAppTypeByTool(String nameTool) {
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new HashSet<AppType>() : tool.getAppType();
    }
    @Override
    public  Set<AppType> getToolJPQL(String nameTool){
        return appTypeRepo.getToolJPQL(nameTool);
    }
    //
    // -------------Table em-----------
    @Override
    public Em getEmByTool(String nameTool) {
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Em() : tool.getEm();
    }
    //-----------Table ebm-----------
    @Override
    public Ebm getEbmByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Ebm() : tool.getEbm();
    }
    //-----------------Table mmem---------
    @Override
    public Mmem getMmemByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Mmem() : tool.getMmem();
    }
    //--------------Table pfm----------
    @Override
    public Pfm getPfmByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Pfm() : tool.getPfm();
    }
    //------------Table mmslt---------
    @Override
    public Mmslt getMmsltByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Mmslt() : tool.getMmslt();
    }
    //------------Table slt---------
    @Override
    public Slt getSltByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Slt() : tool.getSlt();
    }
    //------------Table rfr---------
    @Override
    public Rfr getRfrByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Rfr() : tool.getRfr();
    }
    //------------Table rfa---------
    @Override
    public Rfa getRfaByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Rfa() : tool.getRfa();
    }
    //------------Table rfarn---------
    @Override
    public Rfarn getRfarnByTool(String nameTool){
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new Rfarn() : tool.getRfarn();
    }
    //--------------Table machine-numTool-----------
    @Override
    public Set<NumTool> getNumToolByMachine(String nameMachine){
      Machine machine = machinesRepo.findById(nameMachine).orElse(null);
      return machine == null ? new HashSet<NumTool>() : machine.getNumTool();
    }
    @Override
    public Set<Machine> getMachineByNumTool(String nameNumTool){
      NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
      return numTool == null ? new HashSet<Machine>() : numTool.getMachine();
    }
    //--------------Table tool-numTool-----------
    @Override
    public Set<NumTool> getNumToolByTool(String nameTool) {
        Tool tool = toolRepo.findById(nameTool).orElse(null);
        return tool == null ? new HashSet<NumTool>() : tool.getNumTool();
    }

    @Override
    public String getToolByNumTool(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new String("empty") : numTool.getTool().getNameTool();
    }
    @Override
    @Transactional(readOnly = true)
    public Set<NumTool> getToolJPQL1 (String nameTool){
        return numToolRepo.getToolJPQL1(nameTool);
    }


    //--------------Tables numTool properties-----------
    @Override
    public Holder getHolder(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new Holder() : numTool.getHolder();
    }

    @Override
    public Mmaster getMmaser(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new Mmaster() : numTool.getMmaster();
    }

    @Override
    public Collet getCollet(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new Collet() : numTool.getCollet();
    }

    @Override
    public Shrink getShrink(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new Shrink() : numTool.getShrink();
    }

    @Override
    public Strshank getStrshank(String nameNumTool) {
        NumTool numTool = numToolRepo.findById(nameNumTool).orElse(null);
        return numTool == null ? new Strshank() : numTool.getStrshank();
    }



}

