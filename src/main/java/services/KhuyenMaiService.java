package services;

import domainmodels.KhuyenMai;
import java.util.List;
import repositories.KhuyenMaiRepository;

/**
 *
 * @author Hello
 */
public class KhuyenMaiService {
    private KhuyenMaiRepository khuyenMaiRepo = new KhuyenMaiRepository();
    
    public List<KhuyenMai> getAll(){
        return khuyenMaiRepo.getAll();
    }
    
    public List<KhuyenMai> getAllTrangThai(int trangThai){
        return khuyenMaiRepo.getAllTrangThai(trangThai);
    }
    
    public List<KhuyenMai> getAllByMa(String ma){
        return khuyenMaiRepo.getAllByMa(ma);
    }
    
    public Integer updateSoLuong(String ma){
        return khuyenMaiRepo.updateSoLuong(ma);
    }
}
