package at.htlle.fourconnect;

public class FourConnectView {
    public void printView(String text){
        System.out.println(text);
    }

    public void printlnView(String text){
        System.out.println(text);
    }

    //Yes, we even need to make a new method for visually
    //printing our game, but at least it's not hard to do
    public static void printPattern(String[][] f)
    {
        for (int i =0;i<f.length;i++)
        {
            for (int j=0;j<f[i].length;j++)
            {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }

}
