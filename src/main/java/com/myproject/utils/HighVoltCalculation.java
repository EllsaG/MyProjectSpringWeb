package com.myproject.utils;

import com.myproject.controller.dto.highvoltcable.postget.InductiveResistanceAreasRequestDTO;
import com.myproject.entity.*;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.HighVoltInformationRepository;
import com.myproject.repositories.PowerTransformersRepository;

import java.util.ArrayList;
import java.util.List;

public class HighVoltCalculation {


//    int baseVoltage= 115; //Базисное напряжение U_б=115 кВ
//    int baseFullPower = 300; //Базисная мощность S_б=300 МВА;
//    double relativeBaselineUnrestrictedPowerResistance = 0.5; //Относительное базисное сопротивление неограниченной мощности x_c=x_1=0,5;
//    double highVoltageAirLineLength = 40; // Длина высоковольтной воздушной линии L_1=40 км;
//    double headTransformerFullPower = 160; //Мощность головного трансформатора S_(н.тр1)=160 МВА;
//    double shortCircuitVoltage = 10.5; //Напряжение короткого замыкания U_кз=10,5 %;
//    double cableLineLength = 2.5; //Длина кабельной линии  L_к=2,5 км;
//    double productionHallTransformerFullPower = 1000; //Мощность трансформатора цеховой КТП S_(н.тр2)=1000 кВА;
//    double ratedVoltageOfHigherVoltageWindingOfTransformer = 10.5; //Номинальное напряжение обмотки высшего напряжения U_ВН=10,5 кВ
    //    double[] inductiveImpedanceAreas = {0.5, 0.07, 0.2, 0.54}; // массив областей и их  индуктивное сопротивление

    double ratedVoltageOfLowerVoltageWindingOfTransformer = 0.4; // Номинальное напряжение обмотки  низшего напряжения U_НН=0,4 кВ;

    final double highVoltageAirLineInductiveResistance = 0.08; //индуктивное сопротивление воздушной высоковольтной линии
    final double highVoltageCableLineInductiveResistance = 0.08; //индуктивное сопротивление кабельной высоковольтной линии
    final double highVoltageCableLineActiveResistance = 0.18; //активное сопротивление кабельной высоковольтной линии
    final double surgeCoefficient = 1.8; // ударный коэффициент (на практике использует 1,8, может быть 1,3 при расчете для протяженной высоковольтной ЛЭП)
    final double economicCurrentDensity = 1.2; /* А/〖мм〗^2 – экономическая плотность токаю Может быть другая,
    нужно будет сделать выборку по условию if...else согласно  таблице https://www.elec.ru/library/direction/pue/razdel-1-3-6.html*/
    final double fixedTime = 0.5; /*установленное приведенное время короткого замыкания, с.
    Принимается равным действительному, которое слагается из выдержки времени релейной защиты линий 10 кВ и собственного времени отключающего аппарат.*/
    final double coefficientTakingEmittedHeatDifference = 85; /*коэффициент учитывающий разность выделенной теплоты
    в проводнике до и после короткого замыкания.
    Для кабелей с алюминиевыми жилами коеф = 85;
    */


    public HighVoltInformation shortCircuitCurrentCalculation(long id, int baseVoltage, int baseFullPower,
                                                              double relativeBaselineUnrestrictedPowerResistance,
                                                              double highVoltageAirLineLength, double headTransformerFullPower, double shortCircuitVoltage,
                                                              double cableLineLength, double ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                              List<InductiveResistanceAreasRequestDTO> inductiveResistanceAreasList,
                                                              PowerTransformersRepository powerTransformersRepository) {
        PowerTransformers powerTransformers = powerTransformersRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about power transformer with id № " + id));
        double productionHallTransformerShortCircuitVoltage = powerTransformers.getShortCircuitVoltage();
        double productionHallTransformerFullPower = powerTransformers.getFullPowerOfTransformer();
        double relativeBasisResistance = relativeBaselineUnrestrictedPowerResistance; //Относительное базисное сопротивление x_c=x_1=0,5

        double powerLineRelativeResistance = Math.round(highVoltageAirLineInductiveResistance *
                highVoltageAirLineLength * baseFullPower / Math.pow(baseVoltage, 2) *100)/100.0; //Относительное сопротивление ЛЭП


        double firstTransformerRelativeReactiveResistance = Math.round(shortCircuitVoltage * baseFullPower / (100 * headTransformerFullPower) *100)/100.0; //Относительное реактивное сопротивление трансформатора Т1


        double cableLineRelativeReactiveResistance = Math.round(highVoltageCableLineInductiveResistance * cableLineLength *
                baseFullPower / Math.pow(shortCircuitVoltage, 2) *100)/100.0; //Относительное реактивное сопротивление кабельной линии


        double cableLineRelativeActiveResistance = Math.round(highVoltageCableLineActiveResistance * cableLineLength *
                baseFullPower / Math.pow(ratedVoltageOfHigherVoltageWindingOfTransformer, 2) *100)/100.0;//Активное сопротивление на участке кабельной линии

        double secondTransformerRelativeReactiveResistance = Math.round(productionHallTransformerShortCircuitVoltage * baseFullPower /
                (100 * productionHallTransformerFullPower / 1000)*100)/100.0; //Относительное реактивное сопротивление трансформатора Т2


        double reactiveResistanceAtPointK1 = Math.round(inductiveResistanceAreasList.stream()
                .map(InductiveResistanceAreasRequestDTO::getInductiveResistance)
                .reduce(Double::sum)
                .get() *100)/100.0; //  Реактивное сопротивление до точки k1   (x_∑k1 = x_1 + ... + x_4)

        double baseCurrentAtPointK1 = Math.round(baseFullPower / (Math.sqrt(3) * shortCircuitVoltage) *100)/100.0; //Базисный ток в точке k1

        double fullResistanceAtPointK1 = Math.round(Math.sqrt((Math.pow(cableLineRelativeActiveResistance, 2) + Math.pow(reactiveResistanceAtPointK1, 2))) *100)/100.0;
        /*Полное сопротивление до точки k1 〖 z〗_k1 т.к. cableLineRelativeActiveResistance > (reactiveResistanceAtPointK1 * 0.33)*/


        double shortCircuitCurrentAtPointK1 = Math.round(baseCurrentAtPointK1 / fullResistanceAtPointK1*100)/100.0; // Ток короткого замыкания в точке k1


        double surgeCurrentAtPointK1 = Math.round(Math.sqrt(2) * surgeCoefficient * shortCircuitCurrentAtPointK1 *100)/100.0; // Ударный ток в точке k1

        double shortCircuitPowerAtPointK1 = Math.round(baseFullPower / fullResistanceAtPointK1 *10)/100.0; // Мощность короткого замыкания в точке k1


        double ratedPowerTransformerCurrent = Math.round(productionHallTransformerFullPower /
                (ratedVoltageOfHigherVoltageWindingOfTransformer * Math.sqrt(3)) *100)/100.0; // Номинальный ток силового трансформатора Iном, А

        List<InductiveImpedanceAreas> inductiveImpedanceAreasList = new ArrayList<>();
        for (int i = 0; i < inductiveResistanceAreasList.size(); i++) {
            InductiveImpedanceAreas inductiveImpedanceAreas1 = new InductiveImpedanceAreas();
            inductiveImpedanceAreas1.setInductiveResistance(inductiveResistanceAreasList.get(i).getInductiveResistance());
            inductiveImpedanceAreasList.add(inductiveImpedanceAreas1);
        }

        return new HighVoltInformation(id, highVoltageAirLineInductiveResistance, highVoltageCableLineInductiveResistance, highVoltageCableLineActiveResistance,
                surgeCoefficient, economicCurrentDensity, fixedTime, coefficientTakingEmittedHeatDifference, productionHallTransformerFullPower, baseVoltage,
                baseFullPower, relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage, cableLineLength,
                ratedVoltageOfHigherVoltageWindingOfTransformer, relativeBasisResistance, powerLineRelativeResistance, firstTransformerRelativeReactiveResistance,
                cableLineRelativeReactiveResistance, secondTransformerRelativeReactiveResistance, reactiveResistanceAtPointK1, baseCurrentAtPointK1,
                fullResistanceAtPointK1, shortCircuitCurrentAtPointK1, surgeCurrentAtPointK1, shortCircuitPowerAtPointK1, ratedPowerTransformerCurrent,
                inductiveImpedanceAreasList );

    }

    public ForChooseHighVoltCable forChooseHighVoltCable(HighVoltInformation highVoltInformation) {
        long id = highVoltInformation.getId();
        double ratedPowerTransformerCurrent = highVoltInformation.getRatedPowerTransformerCurrent();
        double shortCircuitCurrentAtPointK1 = highVoltInformation.getShortCircuitCurrentAtPointK1();

        double cableSection = Math.round( ratedPowerTransformerCurrent / economicCurrentDensity*100)/100.0; // Расчёт сечения по экономической плотности S, мм2


        double minCableSectionForChoose = Math.round(shortCircuitCurrentAtPointK1 * 1000 * Math.sqrt(fixedTime) /
                coefficientTakingEmittedHeatDifference*100)/100.0; //Проверка кабеля на термическую устойчивость токам короткого замыкания Sмин , мм2


        if (cableSection > minCableSectionForChoose) {
            return new ForChooseHighVoltCable(id, cableSection);
        } else {
            return new ForChooseHighVoltCable(id, minCableSectionForChoose);
        }
    }

    public HighVoltCables createNewHighVoltCable(long id,String cableType, HighVoltInformationRepository highVoltInformationRepository){
        boolean present = highVoltInformationRepository.findById(id).isPresent();
        if(present){
            return new HighVoltCables(id,cableType);
        }else {
            throw new InformationNotFoundException("Unable to find high volt information. Check the availability of the calculation.");
        }
    }
}