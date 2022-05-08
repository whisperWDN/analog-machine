import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Assembler {
    Map<String,Integer> regNum = new HashMap<>();
    Map<String,Integer> tag = new HashMap<>();
    static final String[] reg = {"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0",
    "$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
    public void init(){
        for(int i=0;i<32;i++)
            regNum.put(reg[i],i);
    }

    public int assemble(String IR){
        String[] fields = IR.split(" ");
        // System.out.println(fields[0]);
        int result = 0;
        int op ;
        int rs ;
        int rd ;
        int rt ;
        int shamt ;
        int funct ;
        if(fields[0].equals("add")){
            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);
            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;
            funct = 32;
            result = (result<<11)|funct;

        }else if(fields[0].equals("addu")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 33;
            result = (result<<11)|funct;

        }else if(fields[0].equals("sub")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 34;
            result = (result<<11)|funct;

        }else if(fields[0].equals("subu")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 35;
            result = (result<<11)|funct;

        }else if(fields[0].equals("and")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 36;
            result = (result<<11)|funct;

        }else if(fields[0].equals("or")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 37;
            result = (result<<11)|funct;

        }else if(fields[0].equals("xor")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 38;
            result = (result<<11)|funct;

        }else if(fields[0].equals("nor")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 39;
            result = (result<<11)|funct;

        }else if(fields[0].equals("multu")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 25;
            result = (result<<11)|funct;

        }else if(fields[0].equals("mult")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 24;
            result = (result<<11)|funct;

        }else if(fields[0].equals("div")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 26;
            result = (result<<11)|funct;

        }else if(fields[0].equals("divu")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 27;
            result = (result<<11)|funct;

        }else if(fields[0].equals("slt")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 42;
            result = (result<<11)|funct;

        }else if(fields[0].equals("sltu")){

            String[] operands=fields[1].split(",");
            rs = regNum.get(operands[1]);

            rt = regNum.get(operands[2]);
            result = (rs<<5)|rt;
            rd = regNum.get(operands[0]);
            result = (result<<5)|rd;

            funct = 43;
            result = (result<<11)|funct;

        }else if(fields[0].equals("sll")){

            String[] operands=fields[1].split(",");
            rt = regNum.get(operands[1]);
            rd = regNum.get(operands[0]);
            result = (rt<<5)|rd;
            shamt = Integer.parseUnsignedInt(operands[2]);
            result = (result<<5)|shamt;

            result = result<<6;

        }else if(fields[0].equals("srl")){

            String[] operands=fields[1].split(",");

            rt = regNum.get(operands[1]);

            rd = regNum.get(operands[0]);
            result = (rt<<5)|rd;
            shamt = Integer.parseUnsignedInt(operands[2]);
            result = (result<<5)|shamt;
            funct = 2;
            result = (result<<6)|funct;

        }else if(fields[0].equals("jr")){

            rs = regNum.get(fields[1]);
            funct = 8;
            result = (rs<<21)|funct;

        }else if(fields[0].equals("j")){
            op = 2;
     
            rd = Integer.parseUnsignedInt(fields[1]);

            rd/=4;

            result = (op<<26)|rd;

        }else if(fields[0].equals("jal")){
            op = 3;
     
            rd = Integer.parseUnsignedInt(fields[1]);

            rd/=4;

            result = (op<<26)|rd;

        }else if(fields[0].equals("beq")){
            op = 4;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[0]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[1]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);

            rd/=4;
            result = (result<<16)|rd;

        }else if(fields[0].equals("bne")){
            op =5;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[0]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[1]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);

            rd/=4;
            result = (result<<16)|rd;

        }else if(fields[0].equals("addi")){
            op = 8;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("addiu")){
            op = 9;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("slti")){
            op = 10;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("sltiu")){
            op = 11;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("andi")){
            op = 12;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }
        else if(fields[0].equals("ori")){
            op = 13;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("xori")){
            op = 14;

            String[] operands=fields[1].split(",");

            rs = regNum.get(operands[1]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[2]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("lb")){
            op = 32;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("lh")){
            op = 33;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("lw")){
            op = 35;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("lbu")){
            op = 36;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("lhu")){
            op = 37;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("sb")){
            op = 40;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("sh")){
            op = 41;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("sw")){
            op = 43;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("ll")){
            op = 48;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }else if(fields[0].equals("sc")){
            op = 56;

            String[] operands=fields[1].split("[,()]");

            rs = regNum.get(operands[2]);
            result = (op<<5)|rs;
            rt = regNum.get(operands[0]);
            result = (result<<5)|rt;
            rd = Integer.parseUnsignedInt(operands[1]);
            result = (result<<16)|rd;

        }
        return result;
//        System.out.println(Integer.toHexString(result));

        
    }
    public void AssembleFile(String filename) {
        init();
        int PC = 0;
        try {
            String IR;
            BufferedReader reader = null;
            String NewFileName = filename.replace("txt","bat");
            FileOutputStream output = new FileOutputStream(NewFileName);
            //遍历生成对照表
            while ((IR = reader.readLine())!=null){
                PC++;
                if(IR.matches("(.*?):(.*?)")){
                    String[] strings=IR.split(":");
                    tag.put(strings[0],PC);
                }
            }
            reader.reset();
            while ((IR = reader.readLine())!=null){
                if(IR.matches("(.*?):(.*?)")){
                    String[] strings=IR.split(":");
                    IR = strings[1];
                }
                int result = assemble(IR);
                output.write(result);
            }
            reader.close();
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(IR);

    }
}
