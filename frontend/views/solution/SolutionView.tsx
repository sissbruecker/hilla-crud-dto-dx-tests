import {AutoCrud} from "@hilla/react-crud";
import {EmployeeSolutionService} from "Frontend/generated/endpoints";
import EmployeeSolutionDTOModel from "Frontend/generated/com/example/application/solution/EmployeeSolutionDTOModel";

export default function SolutionView() {
    return (
        <div className="p-m">
            <AutoCrud
                service={EmployeeSolutionService}
                model={EmployeeSolutionDTOModel}
                gridProps={{
                    visibleColumns: ['name', 'email', 'addressInfo'],
                }}
                formProps={{
                    visibleFields: ['name', 'email', 'street', 'city', 'country']
                }}
            />
        </div>
    );
}
