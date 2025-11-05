package in.ashokit.service;

import in.ashokit.dto.ReportFilterDto;

public interface ReportService {

    public byte[] generateReport(ReportFilterDto filterDto);//byte[] ==>since it's file type, Binary content we are getting
}
