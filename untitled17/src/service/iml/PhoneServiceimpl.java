package service.iml;

import dao.PhoneDao;
import service.PhoneService;

public class PhoneServiceimpl implements PhoneService {
    private final PhoneDao phoneDao;

    public PhoneServiceimpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }
}
