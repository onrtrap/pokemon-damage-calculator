package pro.aws.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pro.aws.springweb.dto.CalculationInputDto;
import pro.aws.springweb.service.CalculationService;

import java.util.Optional;

@Controller
public class MainController {

    private CalculationService calculationService;

    private CalculationInputDto calcInput;

    private int result;
    @Autowired
    public MainController(CalculationService calculationService, CalculationInputDto calcInput){
        System.out.println("Building MainController");
        this.calculationService = calculationService;
        this.calcInput = calcInput;
        this.result = 0;
    }






    @GetMapping("/")
    public String index(Model model){
        Optional<CalculationInputDto> calcOptional = Optional.ofNullable(calcInput);
        if(calcOptional.isEmpty()) {
            calcOptional = Optional.of(new CalculationInputDto());
        }

        model.addAttribute("calcInput", calcOptional.get());

        model.addAttribute("result", result);

        return "index";}

    @PostMapping("/getCalc")
    public String getCalc(@ModelAttribute("calcInput")CalculationInputDto calcInput, Model model){

        if(calcInput.checkValid()){
            int result = calculationService.damageCalc(calcInput);

            model.addAttribute("result", result);

        }

        else{
            model.addAttribute("errorMessage", "Incorrect values; Level must be between 1 and 100 and Power, Attack, and Defense must be more than 0.");

            model.addAttribute("result", result);
        }
        return "index";


    }
}
