<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<jsp:directive.include file="./shared/sidebar.jsp"/>
		</div>
		<div class="col-lg-9">

			<div class="row">

				<div width="100%" align="center" class="col-lg-12">
					<table id="saleddata" class="table table-responsive table-striped table-borderd">
						<thead>
							<tr>
								<th>Invoice / Bill No.</th>
								<th>Bill Date</th>
								<th>No.</th>
								<th>Qty.</th>
								<th>Gross</th>
								<th>Payable Amount</th>
								<th>Outstanding</th>
								<th>Created By</th>
								<th> </th>
 <th><a href="${contextRoot}/POS/bill?bill_id=0" class="btn btn-lg btn-primary" role="button">Add
										New</a></th>
 							</tr>
						</thead>
					</table>
				</div>
			</div>


		</div>

	</div>
</div>