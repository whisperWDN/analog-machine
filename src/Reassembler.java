import java.io.*;
import java.util.Scanner;
public class Reassembler {
    static String[] reg = {"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0",
    "$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    public String reassemble(int IR){
        int op = (IR>>26)&63;
        int rs = 0;
        int rt = 0;
        int rd = 0;
        int shamt = 0;
        int funct = 0;
        String result = "";
        // System.out.println(op);
        switch (op) {
            case 0:
                rs = IR>>21;
                rt = (IR>>16)&31;
                rd = (IR>>11)&31;
                shamt = (IR>>6)&31;
                funct = IR&63;
                switch (funct) {
                    case 0:
                        result = "sll "+reg[rd]+","+reg[rt]+","+shamt;
                        break;                      
                    case 2:
                        result = "srl "+reg[rd]+","+reg[rt]+","+shamt; 
                        break;
                    case 8:
                        result = "jr "+reg[rs]; 
                        break;
                    case 32:
                        result = "add "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 33:
                        result = "addu "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 34:
                        result = "sub "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 35:
                        result = "subu "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 36:
                        result = "and "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 37:
                        result = "or "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 38:
                        result = "xor "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break; 
                    case 39:
                        result = "nor "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 24:
                        result = "mult "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 25:
                        result = "multu "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 26:
                        result = "div "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;
                    case 27:
                        result = "divu "+reg[rd]+","+reg[rs]+","+reg[rt];    
                        break;

                    case 42:
                        result = "slt "+reg[rd]+","+reg[rs]+","+reg[rt];
                        break;

                    case 43:
                        result = "sltu "+reg[rd]+","+reg[rs]+","+reg[rt];
                        break;

                    default:
                        break;
                }
                break;
            case 2:
                rd = IR&0x03ffffff;
                result = "j "+rd*4;    
                break;   
            case 3:
                rd = IR&0x03ffffff;
                result = "jal "+rd*4;    
                break;              
            case 4:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "beq "+reg[rs]+","+reg[rt]+","+rd*4;    
                break;
            case 5:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "bne "+reg[rs]+","+reg[rt]+","+rd*4;    
                break;
            case 8:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "addi "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 9:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "addiu "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 10:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "slti "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 11:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "sltiu "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 12:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "andi "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 13:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "ori "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 14:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "xori "+reg[rt]+","+reg[rs]+","+rd;    
                break;
            case 32:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "lb "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 33:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "lh "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 35:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "lw "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 36:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "lbu "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 37:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "lhu "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 40:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "sb "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;   
            case 41:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "sh "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;             
            case 43:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "sw "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 48:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "ll "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            case 56:
                rs = (IR>>21)&31;
                rt = (IR>>16)&31;
                rd = IR&32767;
                result = "sc "+reg[rt]+","+rd+"("+reg[rs]+")";    
                break;
            default:
                break;
        }
//        System.out.println(result);
        return result;
    }
    public void ReassembleFile(String filename) {
        int IR = 0;
        try {
            FileInputStream input = new FileInputStream(filename);
            String NewFileName = filename.replace("bat","txt");
            PrintWriter pw = null;
            pw = new PrintWriter(new FileWriter(NewFileName),true);
            while ((IR = input.read())!=-1){
                // System.out.println(IR);
                String result = reassemble(IR);
                pw.write(result);
            }
            input.close();
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        int IR = Integer.parseUnsignedInt(s,16);


    }
}
