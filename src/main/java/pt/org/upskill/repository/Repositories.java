package pt.org.upskill.repository;



public class Repositories {

    private static final Repositories instance = new Repositories();
    private Repositories() {  }
    public static Repositories getInstance() {
        return instance;
    }

    RoleRepository roleRepository = new RoleRepository();
    UserRepository userRepository = new UserRepository();

    public RoleRepository roleRepository() {
        return roleRepository;
    }
    public UserRepository userRepository() {
        return userRepository;
    }

    //Your code here
    VaccineRepository vaccineRepository = new VaccineRepository();
    //BrandRepository brandRepository = new BrandRepository();
    //VaccineTechRepository vaccineTechRepository = new VaccineTechRepository();
    //VaccineTypeRepository vaccineTypeRepository = new VaccineTypeRepository();

    FacilityRepository facilityRepository = new FacilityRepository();
    SnsUserRepository snsUserRepository = new SnsUserRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();

//    public VaccineTechRepository vaccineTechRepository() {return vaccineTechRepository;}
//    public VaccineTypeRepository vaccineTypeRepository() {return vaccineTypeRepository;}
    public VaccineRepository vaccineRepository() {return vaccineRepository;}
    //public BrandRepository brandRepository() {return brandRepository;}
  //  public AppointmentRepository appointmentRepository() {return new AppointmentRepository();}

    public FacilityRepository registerFacilityRepository() {
        return facilityRepository;}
    public SnsUserRepository registerSnsUserRepository() {return snsUserRepository;}
    public EmployeeRepository employeeRepository() {return employeeRepository;}
    public FacilityRepository facilityRepository() {return facilityRepository;}

    public AppointmentRepository appointmentRepository() {return new AppointmentRepository();}
}