package se.hrmsoftware.model;

public class OptionalModel {
	public static class Address {
		private final String street;

		public Address(String street) {
			this.street = street;
		}

		public String getStreet() {
			return street;
		}
	}

	public static class ProjectLeader {
		private final Address address;

		public ProjectLeader(Address address) {
			this.address = address;
		}

		public Address getAddress() {
			return address;
		}
	}

	public static class Project {
		private final ProjectLeader projectLeader;
		private final ProjectLeader standIn;

		public Project(ProjectLeader projectLeader, ProjectLeader standIn) {
			this.projectLeader = projectLeader;
			this.standIn = standIn;
		}

		public ProjectLeader getProjectLeader() {
			return projectLeader;
		}

		public ProjectLeader getStandIn() {
			return standIn;
		}
	}
}
