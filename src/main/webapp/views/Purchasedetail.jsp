<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<div class="col-lg-9">

			<div class="row">

				<div width="100%" align="center" class="col-lg-12">
					<table id="purdata"
						class="table table-responsive table-striped table-borderd">
						<thead>
							<tr>
								<th>Pur Id</th>
								<th>Pur Type</th>
								<th>Received From</th>
								<th>Inv No.</th>
								<th>Date</th>

								<th><a href="${contextRoot}/POS/purchase?pur_id=0" class="btn btn-lg btn-primary" role="button">Add
										New</a></th>



								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th><span style="color:orange;">Print Bill</span></th>
								<th>&nbsp;</th>
								  
							</tr>
						</thead>
					</table>
				</div>
			</div>


		</div>

	</div>
</div>