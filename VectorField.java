/**
 * Created by volodymyr.sergiievsk on 11.10.2016.
 */

public class VectorField {

    public  P3 [][][]   f;
    public int nx,ny,nz;

    public VectorField(int Nx,int Ny,int Nz) {
         nx = Nx; ny=Ny; nz=Nz;
         f = new P3[Nx][Ny][Nz];

         for(int ix=0;ix<nx;ix++)
             for(int iy=0;iy<ny;iy++)
                 for(int iz=0;iz<nz;iz++)
                     f[ix][iy][iz] = new P3(0.,0.,0.);
    }

    public void randomInit()  {
        for(int iy=0;iy<ny;iy++) {
            for(int ix=0;ix<nx;ix++) {
                for (int iz = 0; iz < nz; iz++) {
                   f[ix][iy][iz].set(Math.random()-0.5,Math.random()-0.5,Math.random()-0.5);                }
            }
        }

    }


}
