package com.klu.Bean;

public class HospitalBean {
private long Adhar_Num;
public long getAdhar_Num() {
	return Adhar_Num;
}
public void setAdhar_Num(long adhar_Num) {
	Adhar_Num = adhar_Num;
}
private  String Patient_Name;
private  String DoctorType;
private long  Patient_Mobile;
private int Patient_Age;
public String getPatient_Name() {
	return Patient_Name;
}
public void setPatient_Name(String patient_Name) {
	Patient_Name = patient_Name;
}
public String getDoctorType() {
	return DoctorType;
}
public void setDoctorType(String doctorType) {
	DoctorType = doctorType;
}
public long getPatient_Mobile() {
	return Patient_Mobile;
}
public void setPatient_Mobile(long patient_Mobile) {
	Patient_Mobile = patient_Mobile;
}
public int getPatient_Age() {
	return Patient_Age;
}
public void setPatient_Age(int patient_Age) {
	Patient_Age = patient_Age;
}

}
