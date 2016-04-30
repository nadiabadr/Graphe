package testsMeanOfTransport;

import entities.MeanOfTransport;
import entities.Place;
import BusinessDelegator.MeansOfTransportDelegate;
import BusinessDelegator.PlaceServicesDelegate;

public class TestAssignMeanOfTransportToLine {
	public static void main(String[] args) {
		
		
		System.out.println(MeansOfTransportDelegate.doAssignMeanOfTransportToLine("TCV1", 1));
		//System.out.println(MeansOfTransportDelegate.doAssignMeanOfTransportToLine(meanOfTransport1, 1));

	}

}
